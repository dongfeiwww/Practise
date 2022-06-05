# Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
# https://gist.github.com/luoxiaoxun/5925991

def mergeKSortedArr(lists, k):
    q = []
    # push every first ele of lists into the heaq
    for i in range(len(lists)):
        heapq.heappush(q, (lists[i], 0, i))

    # dump all of element
    res = []
    while q:
        val, pos, i = heapq.heappop(q)
        if not res or val != res[-1]:
            res.append(val)
        if pos < len(lists[i])-1:
            pos += 1
            val = lists[i][pos]
            heapq.heappush(q, (val, pos, i))
    return res