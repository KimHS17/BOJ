n, m = map(int, input().split())
num = list(map(int, input().split())) + [0]
mod = [0] * 1000

for i in range(n):
    num[i] += num[i - 1]
    mod[num[i] % m] += 1

cnt = mod[0]

for i in range(1000):
    cnt += mod[i] * (mod[i] - 1) // 2

print(cnt)