package TreeParityMachine;

import NeuralCryptography.RandomNumbers;

public class TreeParityMachine {
    private TreeParityMachineInputVector tpmInputVector;
    
    private final int[] weightsMatrix;
    private final int[] hiddenNeuronsVector;
    private int output;
    
    private final int hiddenNeuronsCount;
    private final int inputNeuronsCount;
    private final int weightDispersion;
    

    public TreeParityMachine(int inputNeuronsCount,int hiddenNeuronsCount, int weightDispersion){
        this.inputNeuronsCount = inputNeuronsCount;
        this.hiddenNeuronsCount = hiddenNeuronsCount;
        this.weightDispersion = weightDispersion;
        weightsMatrix = new int[hiddenNeuronsCount*inputNeuronsCount];
        hiddenNeuronsVector = new int[hiddenNeuronsCount];
        RandomWeights();
    }

    public final void ComputeTPMResult() {
        output = 1;
        for (int i = 0; i < hiddenNeuronsCount; i++) {
            int sum = 0;
            for (int j = 0; j < inputNeuronsCount; j++) {
                sum = sum + (weightsMatrix[i * inputNeuronsCount + j] * tpmInputVector.getInputBit(i * inputNeuronsCount + j));
            }
            hiddenNeuronsVector[i] = TreeParityMachineCommon.signum(sum);
            output = output * TreeParityMachineCommon.signum(sum);
        }
    }

    public final void UpdateWeight() {
        int newWeight;
        for (int i = 0; i < hiddenNeuronsCount; i++) {
            for (int j = 0; j < inputNeuronsCount; j++) {
                newWeight = weightsMatrix[i * inputNeuronsCount + j];
                int areSame =(output == hiddenNeuronsVector[i])? 1:0;
                newWeight = newWeight + tpmInputVector.getInputBit(i * inputNeuronsCount + j) * output * areSame * 1;
                if (newWeight > weightDispersion) {
                    newWeight = weightDispersion;
                }
                if (newWeight < -weightDispersion) {
                    newWeight = -weightDispersion;
                }
                weightsMatrix[i * inputNeuronsCount + j] = newWeight;
            }
        }
    }

    public final void RandomWeights() {
        for (int i = 0; i < hiddenNeuronsCount * inputNeuronsCount; i++) {
            weightsMatrix[i] = weightDispersion - (RandomNumbers.nextNumber() % (2 * weightDispersion + 1));
        }
    }

    public int getHiddenNeuronsCount() {
        return hiddenNeuronsCount;
    }

    public int getInputNeuronsCount() {
        return inputNeuronsCount;
    }

    public int getWeightDispersion() {
        return weightDispersion;
    }
    
    public TreeParityMachineInputVector getTpmInputVector() {
        return tpmInputVector;
    }

    public void setTpmInputVector(TreeParityMachineInputVector tpmInputVector) {
        this.tpmInputVector = tpmInputVector;
    }
    
    public int getWeightValue(int index) {
        return weightsMatrix[index];
    }

    public int[] getHiddenNeuronsVector() {
        return hiddenNeuronsVector;
    }

    public int getOutput() {
        return output;
    }    
   
}
