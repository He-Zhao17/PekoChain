/**
 * <p></p>
 * <p>The Block class</p>
 *
 * @author: He Zhao
 * @create: 2022-08-09 17:52
 */
import java.util.Date;


public class Block {
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp; // as number of milliseconds since 1/1/1970
    private int nonce;

    public Block (String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash () {
        String calculatehash = StringUtility.applySHA256(
                previousHash + Long.toString(nonce) + data);
        return calculatehash;
    }

    public void mineBlock (int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined: " + hash);
    }


}
