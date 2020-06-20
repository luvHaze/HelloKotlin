fun main(){

    var mails = arrayListOf<Int>(9,20,10,30,23,4)
    var period = 3
    var K = 20
    var answer = 0

    for(i in 0..mails.size-period){
        var avg = 0

        for(j in i until i+period){
            avg+=mails[j]
        }

        if(K<=avg/3){
            answer++
        }
    }

    println(answer)
}