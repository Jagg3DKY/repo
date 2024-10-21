import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("HI MY NAME IS KYRAN HEIJKOOP :)"));
		assertTrue(CryptoManager.isStringInBounds("ONCE UPON A TIME IS A VILLAGE FAR FAR AWAY"));
		assertTrue(CryptoManager.isStringInBounds("I AM A SCORPIO"));
		assertFalse(CryptoManager.isStringInBounds("HI MY NAME IS ||KYRAN HEIJKOOP||"));
		assertFalse(CryptoManager.isStringInBounds("{o}"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("XWLN)^YXW)J)]RVN)R\\)J)_RUUJPN)OJ[)OJ[)J J\"", CryptoManager.caesarEncryption("ONCE UPON A TIME IS A VILLAGE FAR FAR AWAY", 265));
		assertEquals("WKLV#LV#D#WHVW", CryptoManager.caesarEncryption("THIS IS A TEST", 67));
		assertEquals("07?H):-HA7=H,716/H7..1+-:", CryptoManager.caesarEncryption("HOW ARE YOU DOING OFFICER", 1000));
		assertEquals("F7 7FF7#&-\\7FFF7+&7FFFF7^&733337+&73337+_\\7337^0$73", CryptoManager.caesarEncryption("/ I // LOVE /// TO //// GO \\\\\\\\ TO \\\\\\ THE \\\\ GYM \\", 23));

	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("WHAT'S UP DOC", CryptoManager.caesarDecryption(":+$7J6C83C'2&", 35));
		assertEquals("PLATO AND ARISTOTLE ARE ANCIENT GREEK PHILOSOPHERS", CryptoManager.caesarDecryption("\\XM [,MZP,M^U_ [ XQ,M^Q,MZOUQZ ,S^QQW,\\TUX[_[\\TQ^_", 12));
		assertEquals("TODAY WAS A GOOD DAY :)", CryptoManager.caesarDecryption("[VKH '^HZ'H'NVVK'KH 'A0", 135));
		assertEquals("HOW'S IT GOING", CryptoManager.caesarDecryption("LS[+W$MX$KSMRK", 68));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("ZN$_^$ FQW%M%%O+WE %LWNN]TS\"%>;", CryptoManager.bellasoEncryption("HI MY NAME IS KYRAN HEIJKOOP :)", "RED"));
		assertEquals("](F_%!!%H/ YWT", CryptoManager.bellasoEncryption("I AM A SCORPIO", "THERE ARE NINE PLANETS IN THE GALAXY"));
		assertEquals("1,^%1;5QQ\"Z%1;D%V[541;D%I[5!^(1%V[5!^(5YJQ5!^,\\^O,1", CryptoManager.bellasoEncryption("/ I // LOVE /// TO //// GO \\\\\\\\ TO \\\\\\ THE \\\\ GYM \\", "BLUE"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("BURGER KING AND MCDONALDS ARE FAST FOOD", CryptoManager.bellasoDecryption("I'WLSY2PN\\N2FSR'_HI]USQI!'SWJ.MSXY.M!TI", "GREEN"));
		assertEquals("DON'T LOOK IN PANDORA'S BOX!", CryptoManager.bellasoDecryption("]TZ3#7%T[W/ '%\\M][(WM3\"7[T$-", "YELLOW"));
		assertEquals("MAGENTA", CryptoManager.bellasoDecryption("!IPX.]T", "THIS IS A LONG CYPHER"));

	}

}
