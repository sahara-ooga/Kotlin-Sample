//二分木
sealed class BtreeNode {
    data class Leaf(
        val data: Int
    ): BtreeNode()//サブクラスとして定義

    data class Branch(
        val left: BtreeNode,
        val right: BtreeNode
    ): BtreeNode()
}

fun main(args: Array<String>) {
    val leaf = BtreeNode.Leaf(data = 0)
    val branch = BtreeNode.Branch(left = leaf, right = BtreeNode.Branch(leaf,leaf))
    println(branch)
}

