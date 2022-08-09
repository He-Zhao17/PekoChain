/**
 * <p></p>
 * <p></p>
 *
 * @author: He Zhao
 * @create: 2022-08-09 17:50
 */
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Date;


public class PekoChain {
    public static ArrayList<Block> blockChain = new ArrayList<>();
    public static int difficulty = 5;

    public static Boolean isChainValid() {
        Block currBlock;
        Block prevBlock;

        for (int i = 1; i < blockChain.size(); i++) {
            currBlock = blockChain.get(i);
            prevBlock = blockChain.get(i - 1);
            if (!currBlock.hash.equals(currBlock.calculateHash())) {
                return false;
            }
            if (!prevBlock.hash.equals(currBlock.previousHash)) {
                return false;
            }
        }
        return true;

    }


    public static void main(String[] args) {
        /*Block genesisBlock = new Block("This is the first block", "0");
        System.out.println("Hash for block 1 : " + genesisBlock.hash);

        Block secondBlock = new Block("This is the second block", genesisBlock.hash);
        System.out.println("Hash for block 2 : " + secondBlock.hash);
*/
        blockChain.add(new Block("This is the first block", "0"));
        System.out.println("Trying to mine block 1......");
        blockChain.get(0).mineBlock(difficulty);

        blockChain.add(new Block("This is the second block", blockChain.get(blockChain.size() - 1).hash));
        System.out.println("Trying to mine block 2......");
        blockChain.get(1).mineBlock(difficulty);

        System.out.println("Blcok is valid: " + isChainValid());
        String blockChainJSON = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println(blockChainJSON);
    }

}
