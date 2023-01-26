elfCalorieSumList = []
elfCalorieSum = 0
topThreeCount = 0
sortedList = []

with open('input.txt','r') as file:
    lines = file.read().splitlines()
for line in lines:
    if line != '':
        elfCalorieSum += int(line)
    else:
        elfCalorieSumList.append(elfCalorieSum)
        elfCalorieSum = 0

for amount in range(len(elfCalorieSumList)):
    for counter in range(amount + 1, len(elfCalorieSumList)):

        if elfCalorieSumList[amount] > elfCalorieSumList[counter]:
           elfCalorieSumList[amount], elfCalorieSumList[counter] = elfCalorieSumList[counter], elfCalorieSumList[amount]

elfCalorieSumList.reverse()
topThreeCount += elfCalorieSumList[0]
topThreeCount += elfCalorieSumList[1]
topThreeCount += elfCalorieSumList[2]

print("Calories from highest to lowest:")
print(elfCalorieSumList)

print("Top three amount of calories:")
print(topThreeCount)