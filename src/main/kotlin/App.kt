import krews.core.*
import krews.run
import reactor.core.publisher.*
import task.*

fun main(args: Array<String>) = run(sampleWorkflow, args)

data class SampleParams(
    val rangeMax: Int
)

val sampleWorkflow = workflow("sample-workflow") {
    val params = params<SampleParams>()

    val base64In = (1..params.rangeMax).toFlux().map { Base64Input(it) }
    val base64Out = base64Task(base64In)

    val zipIn = base64Out.map { ZipInput(it.base64File) }
    zipTask(zipIn)
}