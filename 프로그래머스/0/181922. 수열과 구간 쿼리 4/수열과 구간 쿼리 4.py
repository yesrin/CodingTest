def solution(arr, queries):
    for query in queries:
        s,e,k=query
        for i in range(s, e+1): #range(1, 5)는 [1, 2, 3, 4]를 생성
            if s<=i and i<=e: 
                if i%k==0:
                    arr[i]+=1
    return arr