package org.nd4j.parameterserver.distributed.transport;

import org.nd4j.parameterserver.distributed.conf.VoidConfiguration;
import org.nd4j.parameterserver.distributed.messages.TrainingMessage;
import org.nd4j.parameterserver.distributed.messages.VoidMessage;

/**
 * This interface describes routing for messagins flowing in Client->Shard direction
 *
 * @author raver119@gmail.com
 */
public interface ClientRouter {

    void init(VoidConfiguration voidConfiguration, Transport transport);

    int assignTarget(TrainingMessage message);

    int assignTarget(VoidMessage message);
}