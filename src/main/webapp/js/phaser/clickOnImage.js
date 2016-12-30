/**
 * Created by joliveros on 26/12/2016.
 */
var game = new Phaser.Game(770, 433, Phaser.AUTO, 'image', {preload: preload, create: create});

var text;
var counter = 0;

function preload() {
    game.load.image('simpsons', '../assets/phaser/los-simpson.jpg');
}

function create() {
    var image = game.add.sprite(game.world.centerX, game.world.centerY, 'simpsons');
    image.anchor.set(0.5);
    image.inputEnabled = true;

    text = game.add.text(250, 200, '', {fill: '#000'});

    image.events.onInputDown.add(listener, this);
}

function listener() {
    counter++;
    text.text = "Haz clicado " + counter + " veces!";
}
