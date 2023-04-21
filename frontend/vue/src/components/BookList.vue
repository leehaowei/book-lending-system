<template>
  <div>
    <h1>Books</h1>
    <ul>
      <li v-for="book in books" :key="book.id">
        {{ book.name }} by {{ book.author }}
      </li>
    </ul>
  </div>
</template>

<script>
import { getAllBooks } from "../auth/auth.js";

export default {
  data() {
    return {
      books: [],
    };
  },
  async created() {
    this.books = await getAllBooks();
  },
};
</script>

