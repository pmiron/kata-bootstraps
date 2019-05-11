class StatementFormatter {

    fun format(input: MutableMap<String, Int>): String {
        var amount = 0
        var sb = StringBuilder()
        sb.append("Date|Amount|Balance")
        input.forEach{
                k, v -> run {
                                sb.append("\n")
                                sb.append(k)
                                sb.append("|")
                                sb.append(v)
                                sb.append("|")
                                amount += v
                                sb.append(amount)
                            }
        }

        return sb.toString()
    }
}
