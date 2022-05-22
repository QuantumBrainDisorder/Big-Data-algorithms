/**Rainbow Tabeles can be used for processing passwords.*/
object RainbowTabeles {
    import scala.util.hashing.MurmurHash3.stringHash
    import scala.annotation.tailrec

    /** Returns given 'code' hashed `n` times.*/
    def tailRainbow(code: String, n: Int): String = {
        @tailrec
        def rainbow(x: String, y: Int): String = {
            if (y == 0) x
            else rainbow(stringHash(x).toString, y - 1)
        }
        rainbow(stringHash(code).toString, n)
    }

    def main(args: Array[String]): Unit = {
        println(tailRainbow("AAAA", 100))
    }
}
/** OUTPUT ////////
  * [info] running RainbowTabeles
  * 1881639396
  * [success] Total time: 1 s, completed 2022-05-22 20:41:43
  */









