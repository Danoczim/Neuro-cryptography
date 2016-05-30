package TreeParityMachine;

public class TreeParityMachineClient {

    private TreeParityMachine treeParityMachine;

    private String publicKey;
    private int maximumIterations;
    private int maximumSum;

    public TreeParityMachineClient(int hiddenNeuronsCount, int inputNeuronsCount, int weightDispersion) {
        treeParityMachine = new TreeParityMachine(inputNeuronsCount, hiddenNeuronsCount, weightDispersion);
        publicKey = new String();
    }

    public int getMaximumIterations() {
        return maximumIterations;
    }

    public void setMaximumIterations(int maximumIterations) {
        this.maximumIterations = maximumIterations;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public TreeParityMachine getTreeParityMachine() {
        return treeParityMachine;
    }

    public int getMaximumSum() {
        return maximumSum;
    }

    public void setMaximumSum(int maximumSum) {
        this.maximumSum = maximumSum;
    }
}
