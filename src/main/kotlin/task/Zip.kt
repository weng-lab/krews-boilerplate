package task

import krews.core.*
import krews.file.*
import org.reactivestreams.Publisher
import reactor.core.publisher.Flux

data class ZipParams(val filenamePrefix: String)
data class ZipInput(val base64File: File)
data class ZipOutput(val zipFile: File)

fun WorkflowBuilder.zipTask(i: Publisher<ZipInput>): Flux<ZipOutput> = this.task("gzip", i) {
    val taskParams = taskParams<ZipParams>()

    dockerImage = "alpine:3.8"
    output = ZipOutput(OutputFile("gzip/${input.base64File.filename()}.gz"))
    command =
        """
        mkdir -p /data/gzip
        gzip /data/${input.base64File.path} > /data/gzip/${taskParams.filenamePrefix}-${input.base64File.filename()}.gz
        """
}