package TreeParityMachine;

import NeuralCryptography.RandomNumbers;

public class TreeParityMachineInputVector {
    private int[] inputVector;
    
    public TreeParityMachineInputVector(int hiddenNeuronsCount,int inputNeuronsCount){
        inputVector = new int[hiddenNeuronsCount * inputNeuronsCount];
        for (int i = 0; i < hiddenNeuronsCount * inputNeuronsCount; i++) {
            inputVector[i] = randomBit();
        }
    }
    
    private int randomBit(){
        int A = RandomNumbers.nextNumber() % 2;
        if (A == 0) {
            return - 1;
        } else {
            return  1;
        }
    }
    
    public int getInputBit(int index){
        return inputVector[index];
    }
    
    @Override
    public String toString(){
        String inputVectorString = "";
        for (int i = 0;i < inputVector.length;i++) {
            if(inputVector[i] == 1)
                inputVectorString += "  "+ inputVector[i];
            else
                inputVectorString += " "+inputVector[i];
            inputVectorString += " ";
        }
        return inputVectorString;
    }    
}
