var map = {};
var numIslands = function (grid) {
    var count = 0;
    for (var i = 0; i < grid.length; i++) {
        for (var j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == '1' && map[`${i}_${j}`] == undefined) {
                dfs(i, j, grid.length, grid[0].length, grid, map);
                count++;
            }
        }
    }
    console.log(count);
};

function dfs(i, j, R, C, grid, map) {
    if (isSafe(i, j, R, C, grid, map)) {
        map[`${i}_${j}`] = true;
        dfs(i - 1, j, R, C, grid, map);
        dfs(i + 1, j, R, C, grid, map);
        dfs(i - 1, j, R, C, grid, map);
        dfs(i, j - 1, R, C, grid, map);
        dfs(i, j + 1, R, C, grid, map);
    }
}

function isSafe(i, j, R, C, grid, map) {
    return ((i >= 0) && (i < R) &&
        (j >= 0) && (j < C) &&
        (grid[i][j] == '1' && map[`${i}_${j}`] == undefined));
}

numIslands([
    ['1', '1', '0', '0', '0'],
    ['1', '1', '0', '0', '0'],
    ['0', '0', '1', '0', '0'],
    ['0', '0', '0', '1', '1']
])