class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordList = set(wordList)
        if endWord not in wordList:
            return 0
        wordList.add(beginWord)
        l = len(beginWord)
        dic = defaultdict(list)
        for word in wordList:
            for i in range(l):
                tmp = word[:i] + '_' + word[i + 1:]
                dic[tmp].append(word)
        q1 = deque([beginWord])
        dis1 = {w: 0 for w in wordList}
        dis1[beginWord] = 1
        q2 = deque([endWord])
        dis2 = {w: 0 for w in wordList}
        dis2[endWord] = 1
        flag = True
        while q1 and q2:
            if flag:
                front, dis_front = q1, dis1
                back, dis_back = q2, dis2
            else:
                front, dis_front = q2, dis2
                back, dis_back = q1, dis1 
            cur = front.popleft()
            dist = dis_front[cur]
            next_word = []
            for i in range(l):
                tmp = cur[:i] + '_' + cur[i + 1:]
                for w in dic[tmp]:
                    next_word.append(w)
            for w in next_word:
                if dis_back[w] > 0:
                    return dist + dis_back[w]
                if dis_front[w] == 0:
                    dis_front[w] = dist + 1
                    front.append(w)
            if len(back) < len(front):
                flag = not flag
        return 0