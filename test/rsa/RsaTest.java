package rsa;

import bigint.BigInt32;
import org.junit.Test;
import prime.Generator;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Jakob Pupke
 */
public class RsaTest {

    private Generator generator = new Generator();

    @Test
    public void testRsa() throws ExecutionException, InterruptedException {
        BigInt32 p = new BigInt32("167988556341760475137");
        BigInt32 q = new BigInt32("3560841906445833920513");
        BigInt32 e = new BigInt32(5);
        Rsa rsa = new Rsa(p, q, e);
        assertEquals(rsa.d.toString(), "239272276490031101741495168957570710555853");
        assertEquals(rsa.phiN.toString(), "598180691225077754353737922393926776389632");

        p = new BigInt32("7455602825647884208337395736200454918783366342657");
        q = new BigInt32("4659775785220018543264560743076778192897");
        e = new BigInt32(65537);
        rsa = new Rsa(p, q, e);
        assertEquals(rsa.d.toString(), "11262063260827444975785094392604245467823982685616016111446723766766056794189524545503233");
        assertEquals(rsa.phiN.toString(), "34741437511171958643352682099698961413263372712036566151842030383739565268100676400971776");
    }

    @Test
    public void testRsaEncryptionOne() {
        BigInt32 p = new BigInt32("7455602825647884208337395736200454918783366342657");
        BigInt32 q = new BigInt32("4659775785220018543264560743076778192897");
        BigInt32 e = new BigInt32("65537");
        Rsa rsa = new Rsa(p, q, e);
        assertEquals(rsa.d.toString(), "11262063260827444975785094392604245467823982685616016111446723766766056794189524545503233");
        assertEquals(rsa.phiN.toString(), "34741437511171958643352682099698961413263372712036566151842030383739565268100676400971776");

        Keys keys = rsa.generateRSAKeys();

        BigInt32 plain = new BigInt32("101010101010101010101010101010101010101010101010101");
        BigInt32 cipher = Rsa.encrypt(keys.publicKey, plain);
        assertEquals("27111590498907479264063099212422881113911020038393673903317634717063990382938277785075436", cipher.toString());

        plain = new BigInt32("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
        cipher = Rsa.encrypt(keys.publicKey, plain);
        assertEquals("28312674675448741954945253509443646729637149696304140849333467206924203883368676685674938", cipher.toString());

        plain = new BigInt32("2831267467544874195494525350944364672963714969630414453534543206924203883368676685674938");
        cipher = Rsa.encrypt(keys.publicKey, plain);
        assertEquals("2813100659035262240598776931593725185995578130992815931492584234554126077338982191626214", cipher.toString());
    }

    @Test
    public void testRsaEncryptionTwo() {
        BigInt32 p = new BigInt32("167988556341760475137");
        BigInt32 q = new BigInt32("3560841906445833920513");
        BigInt32 e = new BigInt32(5);
        Rsa rsa = new Rsa(p, q, e);
        assertEquals(rsa.d.toString(), "239272276490031101741495168957570710555853");
        assertEquals(rsa.phiN.toString(), "598180691225077754353737922393926776389632");

        Keys keys = rsa.generateRSAKeys();

        BigInt32 plain = new BigInt32("9999999999999999");
        BigInt32 cipher = Rsa.encrypt(keys.publicKey, plain);
        assertEquals("12224338883742997042704720712597186518930", cipher.toString());

        plain = new BigInt32("99999999999999999999999999999999999999999");
        cipher = Rsa.encrypt(keys.publicKey, plain);
        assertEquals("82330858952101937430704180007979568105111", cipher.toString());

        plain = new BigInt32("101010101010101010101010101010101010101010");
        cipher = Rsa.encrypt(keys.publicKey, plain);
        assertEquals("355876984919102599359304006246672502129884", cipher.toString());
    }

    @Test
    public void testDecryptEncrypt() {
        BigInt32 p = new BigInt32(5);
        BigInt32 q = new BigInt32(17);
        BigInt32 e = new BigInt32(43);
        Rsa rsa = new Rsa(p,q,e);
        assertEquals(rsa.d.toString(), "3");
        Keys keys = rsa.generateRSAKeys();
        assertEquals("85", keys.publicKey.n.toString());
        assertEquals("43",  keys.publicKey.e.toString());
        assertEquals("85", keys.secretKey.n.toString());
        assertEquals("3", keys.secretKey.d.toString());

        BigInt32 plain = new BigInt32(2);
        BigInt32 cipher = Rsa.encrypt(keys.publicKey, plain);
        BigInt32 deciphered = Rsa.decrypt(keys.secretKey, cipher);
        assertEquals(plain.toString(), deciphered.toString());

    }

    @Test
    public void testDecryptEncryptTwo() throws InterruptedException, ExecutionException {
        // Size 10 of BigInt32 is equivalent to 310bit => size 20 = 620bit...
        // 20 * log(2147483646) / log(2) = 620
        int size = 10;
        BigInt32 e = new BigInt32("7919");
        Rsa rsa = new Rsa(e, size);
        Keys keys = rsa.generateRSAKeys();

        // Some random message
        BigInt32 plain = generator.getRandom(size);
        BigInt32 cipher = Rsa.encrypt(keys.publicKey, plain);
        BigInt32 deciphered = Rsa.decrypt(keys.secretKey, cipher);
        assertEquals(plain.toString(), deciphered.toString());
        
    }
}
