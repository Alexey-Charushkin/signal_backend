FROM node:18.16.0

WORKDIR /app
COPY package.json package-lock.json /app/
RUN npm install
COPY . /app
RUN npm run build
CMD ["npm", "start"]