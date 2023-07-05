const path = require("path");
const webpack = require("webpack");
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const webpackDevServer = require('webpack-dev-server');



module.exports = {
  entry: "./src/index.js",
  output: {
    path: path.resolve(__dirname, "./build"),
    filename: 'main.[contenthash].js',
    clean: true
  },
  devServer: {
    static: {
      directory: path.resolve(__dirname, './build'), // Корневая директория для сервера
    },
    port: 3000, // Порт, на котором будет запущен сервер
  },
  module: {
    rules: [

        {
          test: /\.(js|jsx)$/,
          exclude: /node_modules/,
          use: {
            loader: 'babel-loader',
            options: {
              presets: ['@babel/preset-react'],
            },
          },
        },
        {
            test: /\.(c|sa|sc)ss$/i,
            exclude: /node_modules/,
            use: [
              'style-loader',
              'css-loader',
              {
                loader: 'postcss-loader',
                options: {
                  postcssOptions: {
                    plugins: [require('postcss-preset-env')],
                  },
                },
              },

              {
                loader: 'sass-loader',
                options: {
                  sourceMap: true,
                },
              },
            ],
        },
    ],
  },
  optimization: {
    minimize: true,
  },
  plugins: [
    new CleanWebpackPlugin(),
    new HtmlWebpackPlugin({
      template: './public/index.html', // Путь к вашему EJS-шаблону
      inject: 'body',
      filename: 'index.html'
    }),
  ],
};