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
        if(tiles[i][j] !== 0){
            $('#tile' + tileIndex).text(tiles[i][j]);
            $('#tile' + tileIndex).removeClass();
            $('#tile' + tileIndex).addClass('tile tile-' + (tiles[i][j] <= 2048 ? tiles[i][j] : 'super'));
        } else {
            $('#tile' + tileIndex).text('');
            $('#tile' + tileIndex).removeClass();
            $('#tile' + tileIndex).addClass('tile');
        }

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

$(document).keydown(function(e) {
    switch(e.which) {
        case 37: move('3')// left
        break;
        case 38: move('0')// up
        break;
        case 39: move('1')// right
        break;
        case 40: move('2')// down
        break;
        default: return; // exit this handler for other keys
    }
    e.preventDefault(); // prevent the default action (scroll / move caret)
});