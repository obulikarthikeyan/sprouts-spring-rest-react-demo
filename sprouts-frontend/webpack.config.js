var path = require('path');
var webpack = require('webpack');
const HtmlWebPackPlugin = require("html-webpack-plugin");

const htmlPlugin = new HtmlWebPackPlugin({
  template: "./src/index.html",
  filename: "index.html"
});

module.exports = {
    entry: './src/main/js/index.js',
    devtool: 'sourcemaps',
    mode: 'development',
    cache: true,
    plugins: [
          new webpack.LoaderOptionsPlugin({
            debug: true
          }),
          htmlPlugin
    ],
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'application.js'
    },

    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: "babel-loader"
                }
            }
        ]
    }
};