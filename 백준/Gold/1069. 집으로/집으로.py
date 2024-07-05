from sys import stdin  
import math 
x,y,d,t = map(int,stdin.readline().split())

distance = math.sqrt(x**2 + y**2) 

if distance >= d:
    time = min(t*(distance//d) + distance % d, t * (distance // d + 1), distance)
else:
    time = min(t + (d - distance), 2 * t, distance)
print(time)