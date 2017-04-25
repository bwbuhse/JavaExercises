package compproblems.pactf;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RememberMD5 {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						for (int m = 0; m < 3; m++) {
							for (int n = 0; n < 3; n++) {
								for (int o = 0; o < 3; o++) {
									for (int p = 0; p < 3; p++) {
										for (int q = 0; q < 3; q++) {
											for (int r = 0; r < 3; r++) {
												for (int s = 0; s < 3; s++) {
													for (int t = 0; t < 3; t++) {
														for (int u = 0; u < 3; u++) {
															for (int v = 0; v < 3; v++) {
																String name = convert(i, j, k, l, m, n, o, p, q, r, s, t, u, v);
																md.update(name.getBytes());
																byte[] digest = md.digest();
																String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
																if (myHash.equals("1b657b7fe26eda5b3c1309d340f1674d".toUpperCase())) {
																	System.out.println(name);
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private static String convert(int... nums) {
		String ret = "";
		for (int num : nums) {
			switch (num) {
				case 0:
					ret += "a";
					break;
				case 1:
					ret += "b";
					break;
				case 2:
					ret += "c";
					break;
			}
		}
		return ret;
	}
}
