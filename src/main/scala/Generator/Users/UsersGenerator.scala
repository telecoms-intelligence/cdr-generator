package generator.users

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import java.util.Random

import model._
import spark.Spark.spark

abstract class UsersGenerator() extends Serializable{
	def generate(
		cells: Array[Cell],
		operators: Array[Operator] 
		) : org.apache.spark.rdd.RDD[User]
}

class BasicUsersGenerator(nUsers: Int) extends UsersGenerator {
	protected val rand = new Random

	override def generate(
		cells: Array[Cell],
		operators: Array[Operator] 
		) : org.apache.spark.rdd.RDD[User] = {

			spark.sparkContext.parallelize( 1 to nUsers map{ id => 
				new DumUser( id, operators(0), sampleCells(cells)(0) )
			})

	}

	def sampleCells(cells: Array[Cell]): Array[Cell] = {
		val size = rand.nextInt(cells.length);
		val set = Set( 0 to size map{_ =>
				cells(rand.nextInt(cells.length))
			} :_*)
		set.toArray
	}
}
