package task

import krews.core.*
import krews.file.*
import org.reactivestreams.Publisher
import reactor.core.publisher.Flux

data class Base64Params(val msg: String)
data class Base64Input(val index: Int)
data class Base64Output(val base64File: File)

fun WorkflowBuilder.base64Task(i: Publisher<Base64Input>): Flux<Base64Output> = this.task("base64", i) {
    val taskParams = taskParams<Base64Params>()
    val msg = taskParams.msg
    val index = input.index

    dockerImage = "alpine:3.9"
    output = Base64Output(OutputFile("base64/$index.b64"))
    command =
        """
        mkdir -p /data/base64
        echo "$msg $index!" | base64 > /data/base64/$index.b64
        """
}