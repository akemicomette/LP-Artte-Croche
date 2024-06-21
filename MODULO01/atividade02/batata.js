const matrixA = [[1, 2, 3, 4], [2, 3, 4, 5]];
const matrixB = [[2, 3, 4], [3, 4, 5], [4, 5, 6], [5, 6, 7]];

const size1 = { height: matrixA.length, width: matrixA[0].length };
const size2 = { height: matrixB.length, width: matrixB[0].length };

const resultDimensions = { height: size1.height, width: size2.width };
const result = Array.from({ length: resultDimensions.height }, () => ([]));

for (let row = 0; row < size1.height; row++) {
  for (let column = 0; column < size2.width; column++) {
    let sum = 0;
    for (let i = 0; i < size1.width; i++) {
      sum += matrixA[row][i] * matrixB[i][column];
    }
    result[row][column] = sum;
  }
}

console.log(resultDimensions);
console.log(result);