var player = "X"
var round = 1

fun main() {
    var table = arrayOf(
        arrayOf(" ", "1", "2", "3"),
        arrayOf("1", "-", "-", "-"),
        arrayOf("2", "-", "-", "-"),
        arrayOf("3", "-", "-", "-")
    )

    while (true) {
        println("round : " + round)
        printTable(table)
        switchPlayer(round)
        println("Turn " + player)

        try {
            print("Input : ")
            var input = readLine()!!
            var index = input.split(" ")

            if (index[0].toInt() in 1..3 && index[1].toInt() in 1..3) {
                if (table[index[0].toInt()][index[1].toInt()] != "-") {
                    println("---ตำแหน่งซ้ำ โปรดเลือกตำแหน่งอิื่น---")
                    println()
                    continue
                } else {
                    table[index[0].toInt()][index[1].toInt()] = player
                }
            } else {
                println("---ตำแหน่งไม่ถูกต้อง กรุณากรอกตำแหน่งใหม่---")
                println()
                continue
            }
        } catch (e: Throwable) {
            println("---กรุณากรอกตำแหน่ง---")
            println()
            continue
        }
        println()
        if (checkWin(round, table)) {
            printTable(table)
            if (!checkCon(table)) {
                System.exit(0)
            } else {
                continue
            }
        }
        round++
    }
}

fun switchPlayer(round: Int) {
    if (round % 2 == 0) {
        player = "O"
    } else {
        player = "X"
    }
}

fun checkWin (round: Int, table: Array<Array<String>>) : Boolean {
    if (round == 9) {
        printTable(table)
        println("---เสมอ---")
        return true
    } else {
        //Check win in Horizontal
        if(table[1][1] == table [1][2] && table[1][2] == table[1][3] && table[1][1] != "-"){
            println("*----" + player +  " ชนะ!!!----*")
            return true
        }else if (table[2][1] == table [2][2] && table[2][2] == table[2][3] && table[2][1] != "-"){
            println("*----" + player +  " ชนะ!!!----*")
            return true
        }else if (table[3][1] == table [3][2] && table[3][2] == table[3][3] && table[3][1] != "-"){
            println("*----" + player +  " ชนะ!!!----*")
            return true
        }
        //Check win in vertical
        if(table[1][1] == table [2][1] && table[2][1] == table[3][1] && table[1][1] != "-"){
            println("*----" + player +  " ชนะ!!!----*")
            return true
        }else if (table[1][2] == table [2][2] && table[2][2] == table[3][2] && table[1][2] != "-"){
            println("*----" + player +  " ชนะ!!!----*")
            return true
        }else if (table[1][3] == table [2][3] && table[2][3] == table[3][3] && table[1][3] != "-"){
            println("*----" + player +  " ชนะ!!!----*")
            return true
        }
        //Check win in diagonal
        if(table[1][1] == table [2][2] && table[2][2] == table[3][3] && table[1][1] != "-"){
            println("*----" + player +  " ชนะ!!!----*")
            return true
        }else if (table[1][3] == table [2][2] && table[2][2] == table[3][1] && table[1][3] != "-"){
            println("*----" + player +  " ชนะ!!!----*")
            return true
        }

        return false
    }
}

fun checkCon (table: Array<Array<String>>) : Boolean {
    print("หากต้องการเล่นอีกครั้งพิมพ์ yes ถ้าไม่พิมพ์ no")
    println()
    var answer = readLine()!!
    if (answer == "yes") {
        clearTable(table)
        player = "X"
        round = 1
        return true
    } else {
        return false
    }
}

fun printTable (table: Array<Array<String>>) {
    for (row in table.indices) {

        for (column in table[row].indices) {
            print(table[row][column] + " ")
        }
        println()
    }
}

fun clearTable (table: Array<Array<String>>) {
    for (row in 1..3){
        for (column  in 1..3){
            table[row][column] = "-"
        }
    }
}

