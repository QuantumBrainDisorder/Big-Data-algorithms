object FrequencyMoment {
    import scala.math.BigInt
    import scala.io.Source

    /** Returns list of words in given path `file`.*/
    def readFile(file: String): List[String] = {
        val fileSource = Source.fromFile(file)
        val stream = fileSource.mkString.split("\\W+")
        fileSource.close
        stream.toList
    }

    /** Returns frequency moment `order` for given stream.*/
    def moment(stream: List[String], order: Int): BigInt = {
        val streamSet = stream.distinct
        val streamSetFrequences = streamSet.map(i => BigInt(stream.filter(j => j == i).length))
        val moment = streamSetFrequences.toList.fold(BigInt(0))((i, j) => i + j.pow(order))
        moment
    }

    def main(args: Array[String]){
        val stream = readFile(raw"./alice29.txt")
        (0 to 3) foreach (i => println(moment(stream, i)))
    }
}
/** OUTPUT ////////
  *[info] running FrequencyMoment
  *2962
  *27334
  *6784598
  *5672166808
  *[success] Total time: 6 s, completed 2022-05-22 21:36:23
  */
