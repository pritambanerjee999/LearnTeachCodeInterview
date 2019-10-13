#!/usr/bin/python

def maxScorePath(m):
   unvisited = set((i, j) for i in range(len(m)) for j in range(len(m[0])))
   maxScore = { (i, j): 0 for (i, j) in unvisited }
   maxScore[(0, 0)] = m[0][0]

   while unvisited:
      maxPos = None
      maxPosScore = -1
      for u in unvisited:
         if maxScore[u] > maxPosScore:
            maxPos = u
            maxPosScore = maxScore[u]

      unvisited.remove(maxPos)
      (i, j) = maxPos
      neighborPositions = []
      if i > 0:
         neighborPositions.append((i-1, j))
      if i < len(m)-1:
         neighborPositions.append((i+1, j))
      if j > 0:
         neighborPositions.append((i, j-1))
      if j < len(m[0])-1:
         neighborPositions.append((i, j+1))
      for k, l in neighborPositions:
         score = min(maxScore[(i, j)], m[k][l])
         if score > maxScore[(k, l)]:
            maxScore[(k, l)] = score
   return maxScore[(len(m)-1, len(m[0])-1)]

if __name__ == '__main__':
   #m = [[5, 4, 5],
   #     [1, 2, 6],
   #     [7, 4, 6]]
   #m = [[2, 2, 1, 2, 2, 2],
   #     [1, 2, 2, 2, 1, 2],]
   #m = [[3, 4, 6, 3, 4],
   #     [0, 2, 1, 1, 7],
   #     [8, 8, 3, 2, 7],
   #     [3, 2, 4, 9, 8],
   #     [4, 1, 2, 0, 0],
   #     [4, 6, 5, 4, 3]]
   m = [[10, 8, 3],
        [7, 0, 3],
        [4, 4, 4]]
   print maxScorePath(m)
