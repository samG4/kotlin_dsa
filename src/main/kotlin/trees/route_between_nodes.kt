package trees
fun main() {
    val graph = Graph<Vertex<Int>>()
    val vertices = (1..7).associateWith { Vertex(it) }

    graph.addEdge(vertices[1]!!, vertices[2]!!)
    graph.addEdge(vertices[1]!!, vertices[3]!!)
    graph.addEdge(vertices[2]!!, vertices[4]!!)
    graph.addEdge(vertices[3]!!, vertices[5]!!)
    graph.addEdge(vertices[4]!!, vertices[6]!!)
    graph.addEdge(vertices[5]!!, vertices[6]!!)

    graph.printGraph()
    println("Graph route -> ${graph.hasRoute(vertices[1]!!, vertices[7]!!)}")
}

class Graph<T> {
    private val adjacencyList = mutableMapOf<T, MutableList<T>>()

    fun addEdge(source: T, destination: T) {
        adjacencyList.computeIfAbsent(source) { mutableListOf() }.add(destination)
        adjacencyList.computeIfAbsent(destination) { mutableListOf() }
    }

    fun getNeighbors(node: T): List<T> = adjacencyList[node] ?: emptyList()

    fun printGraph() {
        adjacencyList.forEach { (node, neighbors) ->
            println("$node -> ${neighbors.joinToString(", ")}")
        }
    }

    fun hasRoute(start: T, end: T): Boolean {
        if (start == end) return true
        val queue = ArrayDeque<T>().apply { add(start) }
        val visited = mutableSetOf(start)

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (node == end) return true
            getNeighbors(node).filter { it !in visited }.forEach {
                queue.add(it)
                visited.add(it)
            }
        }
        return false
    }
}

data class Vertex<T>(val data: T)
