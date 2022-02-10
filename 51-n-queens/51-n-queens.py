class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        blockedColumn = set()
        minusDiagonal = set()
        plusDiagonal = set()
        
        chessboard = [['.'] * n for col in range(n)]
        ans = []
        
        self.canPutQueen(0, n, chessboard, blockedColumn, minusDiagonal, plusDiagonal, ans)
        
        return ans
    
    def canPutQueen(self, current_row, n, chessboard, blockedColumn, minusDiagonal, plusDiagonal, ans):
        if current_row == n:
            pos = []
            for i in range(len(chessboard)):
                pos.append(''.join(chessboard[i]))
            ans.append(pos)
            return
        
        for col in range(n):
            if col in blockedColumn or (current_row + col) in plusDiagonal or (current_row - col) in minusDiagonal:
                continue
            
            blockedColumn.add(col)
            plusDiagonal.add(current_row + col)
            minusDiagonal.add(current_row - col)
            
            chessboard[current_row][col] = 'Q';
            
            self.canPutQueen(current_row + 1, n, chessboard,  blockedColumn, minusDiagonal, plusDiagonal, ans)
            
            chessboard[current_row][col] = '.';
            blockedColumn.remove(col)
            plusDiagonal.remove(current_row + col)
            minusDiagonal.remove(current_row - col)
        
        