"""\Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
"""

def merge(intervals: List[List[int]]) -> List[List[int]]:
    intervals = sorted(intervals)
    res = [intervals[0]]
    for i in range(1, len(intervals)):
        cur = intervals[i]
        last = res[-1]
        # no overlap
        if cur[0] > last[1]:
            res.append(cur)
        else:
            last[1] = max(last[1], cur[1])
    return res

class Solution:
    def merge(intervals):
        intervals.sort()
        
        i=0
        j=1
        
        while i< len(intervals) and j< len(intervals):
            if(intervals[i][1] >= intervals[j][0]):
                intervals[i][1] = max(intervals[i][1], intervals[j][1])
                j+=1
            else:
                i+=1
                intervals[i] = intervals[j]
                # intervals[i][1] = intervals[j][1];
                j+=1


        return intervals[0: i+1]
