package main.scala.com.rnd.interviewscraper

import main.scala.com.rnd.interviewscraper.scrapers.JPmorgan

object Main {
  def main(args: Array[String]): Unit = {

    new JPmorgan().scrape()

  }
}