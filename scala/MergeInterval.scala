package com.github.johnmidavis.exercises.scala

/**
* Author: John M I Davis
*
* Example taken from http://www.programcreek.com/2012/12/leetcode-merge-intervals/
*
* my first attempt at Scala 
*
* Given a collection of intervals, merge all overlapping intervals.
*
*  For example,
*  Given [1,3],[2,6],[8,10],[15,18],
*  return [1,6],[8,10],[15,18].
*/

object MergeInterval {
  import scala.collection.mutable.ArrayBuffer

  val inputIntervals: Array[(Int,Int)] = Array(
    (8,10),
    (2,6),
    (1,3),
    (15,18)
  )

  def main(args: Array[String]) {
    // print the input
    println("original")
    println(inputIntervals.deep)

    // sort intervals on left hand element
    val sortedIntervals = inputIntervals.sortWith(_._1 < _._1)

    // set a sentry inteval as the zero length inteval
    // based at the smallest start value
    var currentInterval = (sortedIntervals(0)._1,sortedIntervals(0)._1)

    //set a buffer for outputting the result
    var output = new ArrayBuffer[(Int,Int)]

    for (interval <- sortedIntervals){
      if(currentInterval._2 < interval._1){
        // intervals are disjoint
        // save the last one and restart with the current
        output += currentInterval
        currentInterval = interval
      } else {
        // keep building the interval
        currentInterval = (currentInterval._1,interval._2)
      }     
    }

    // save the last working interval
    output += currentInterval

    // convert to an array
    val outputIntervals = output.toArray

    // print result
    println("reduced")
    println(outputIntervals.deep)
  }

}



