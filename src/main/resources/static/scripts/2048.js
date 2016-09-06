var gameId;

function newGame() {
   $.ajax({
           url: "/2048/new"
       }).then(function(data) {
          gameId = data.id;
          $('.game-id').append(data.id);
          displayData(data);
       });
};

function displayData(data){
  $('.game-score').text("Score: " + data.score);
  var tiles = data.board.tiles;
  for (var i = 0; i < 4; i++) {
    for(var j = 0; j< 4; j++){
        var tileIndex = i * 4 + j;
        $('#tile' + tileIndex).text(data.board.tiles[i][j]);
    }
  }

  console.log(data);
}

function move(direction) {
   $.ajax({
           url: "/2048/" + gameId + "/" + direction
       }).then(function(data) {
          displayData(data);
       });
};
