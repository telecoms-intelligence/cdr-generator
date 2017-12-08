package spark

object Spark {
  // Creation of the SparkSession
  val spark = org.apache.spark.sql.SparkSession
    .builder()
    .appName("CDR-Generation")
    .config("spark.master", "local")
    .getOrCreate()
}

