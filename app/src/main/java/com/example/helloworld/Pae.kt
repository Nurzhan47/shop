package com.example.helloworld

import org.jsoup.Jsoup

fun main() {
    println("YEP")
    val url =
        "\thttps://www.technodom.kz/p/televizor-ava-43-ua43s6000-led-fhd-android-black-260006\n"
    val doc = Jsoup.connect(url).get()
    val link = doc.select("img").first()
    val linkHref = link.attr(
        "srcset=/_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F800%2F800%2F260006_1.jpg&w=640&q=85 640w, /_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F800%2F800%2F260006_1.jpg&w=750&q=85 750w, /_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F800%2F800%2F260006_1.jpg&w=750&q=85 750w, /_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F800%2F800%2F260006_1.jpg&w=828&q=85 828w, /_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F800%2F800%2F260006_1.jpg&w=1080&q=85 1080w, /_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F800%2F800%2F260006_1.jpg&w=1200&q=85 1200w, /_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F800%2F800%2F260006_1.jpg&w=1200&q=85 1200w, /_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F800%2F800%2F260006_1.jpg&w=1920&q=85 1920w, /_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F800%2F800%2F260006_1.jpg&w=1920&q=85 1920w, /_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F800%2F800%2F260006_1.jpg&w=2048&q=85 2048w, /_next/image?url=https%3A%2F%2Fapi.technodom.kz%2Ff3%2Fapi%2Fv1%2Fimages%2F800%2F800%2F260006_1.jpg&w=3840&q=85 3840w"
    )
    println(linkHref)

}