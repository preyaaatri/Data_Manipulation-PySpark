import org.apache.spark
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql
import org.apache.spark.SparkContext
import org.apache.spark.sql.types.DataTypes
import java.sql.Timestamp

import org.apache.spark.sql.SQLContext

case class StructType(fields: Array[StructField])

case class StructField(
        name: String,
        dataType: DataType,
        nullable: Boolean = true
)

object Fda {
    
    def getType(raw: Any): DataType = {
      raw match {
        case "byte" => ByteType
        case "short" => ShortType
        case "integer" => IntegerType
        case "long" => LongType
        case "float" => FloatType
        case "number" => DoubleType
        case "boolean" => BooleanType
        case "datetime" => TimestampType
        case _ => StringType
      }
    }
    
    
    def main(args: Array[String]): Unit = {
        val spark = SparkSession
          .builder()
          .appName("PreyAssignment")
          .config("spark.some.config.option", "some-value")
          .getOrCreate()
        
        val filePath = "./DM-classification.json"
        val df = spark.read.option("multiline", true).json("./DM-classification.json")
        
//         #TODO
//         println(df.select(explode(df("schema.fields"))).toDF("level1").show())
        
        
        
//         println(df.select(explode(df("schema.fields"))).toDF("level1")
//                   .select("level1.name","level1.type")
//                   .show()
//                )
        
        val col_list = df.select(explode(df("schema.fields"))).toDF("level1")
                          .select("level1.type")
        val list1 = col_list.select("type").collect().map(_(0)).toList
        
        println(list1(0))
        println(list1)
        
        
        
        val tf = df.select(explode(df("data"))).toDF("temp")
        .select("temp.content", "temp.label", "temp.label_1", "temp.label_2", "temp.label_3", "temp.label_4")
        
        val new_columns = Seq("content","label","size","usage","effect","date")
        
        val new_df = tf.toDF(new_columns:_*)
        new_df.show()
        
        
        val newSeqOfSeq = new_df.collect().map(row => row.toSeq.map(_.toString).toSeq).toSeq
        
        println(newSeqOfSeq)
        
        
        
        val simpleSchema = StructType(Array(
            StructField("content",getType(list1(1)),true),
            StructField("label",getType(list1(2)),true),
            StructField("size",getType(list1(3)),true),
            StructField("usage", getType(list1(4)), true),
            StructField("effect", getType(list1(5)), true),
            StructField("date", getType(list1(6)), true)
          ))
        
        
        
        
        
        
        
        val final_df = spark.createDataFrame(spark.sparkContext.parallelize(newSeqOfSeq),simpleSchema)
        final_df.printSchema()
        final_df.show()
        
        
//         new_df.createOrReplaceTempView("temp_table")
        
    
// //         temp_table.printSchema()
        
//         spark.sql("""SELECT COUNT (*) FROM temp_table""").show()
        
        
        
    }
}

Fda.main(Array(""))


