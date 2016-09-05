function newGame() {
   $.ajax({
           url: "/2048/new"
       }).then(function(data) {
          $('.game-id').append(data.id);
          $('.game-score').append(data.score);
          $('.game-board').append(data.board.tiles);
          console.log(data);
       });
};