package org.nd4j.linalg.activations.impl;

import org.apache.commons.math3.util.Pair;
import org.nd4j.linalg.activations.IActivation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.impl.transforms.Sigmoid;
import org.nd4j.linalg.api.ops.impl.transforms.SigmoidDerivative;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.ops.transforms.Transforms;

/**
 * Created by susaneraly on 12/5/16.
 */
public class ActivationSigmoid implements IActivation {

    public INDArray computeActivation(INDArray in){
        return Nd4j.getExecutioner().execAndReturn(new Sigmoid(in));
    }

    public INDArray computeGradient(INDArray in) {
        return Nd4j.getExecutioner().execAndReturn(new SigmoidDerivative(in));
    }

    public Pair<INDArray, INDArray> computeGradientAndActivation(INDArray in) {
        return new Pair<INDArray, INDArray>(
                computeActivation(in),
                computeGradient(in)
        );
    }

    /* need to implement
    numParams();

    setParamsViewArray(INDArray, boolean initialize);

    setBackpropViewArray();

    */
}