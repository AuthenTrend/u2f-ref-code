package com.google.u2f.server.impl.androidattestation;

import java.security.cert.CertificateParsingException;
/**
 * Keysmaster purpose values as taken from: keymaster_defs.h
 */
public enum Purpose {
  KM_PURPOSE_ENCRYPT(0, "encrypt"),
  KM_PURPOSE_DECRYPT(1, "decrypt"),
  KM_PURPOSE_SIGN(2, "sign"),
  KM_PURPOSE_VERIFY(3, "verify");

  private final int value;
  private final String description;

  public static Purpose fromValue(int value) throws CertificateParsingException {
    for (Purpose purpose : Purpose.values()) {
      if (purpose.getValue() == value) {
        return purpose;
      }
    }

    throw new CertificateParsingException("Invalid purpose value: " + value);
  }

  private Purpose(int value, String description) {
    this.value = value;
    this.description = description;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return description;
  }
}
