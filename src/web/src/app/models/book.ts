import {Author} from './author';
import {Category} from './category';

export class Book {
  id!: number;
  title!: string;
  price!: number;
  releaseDate!: Date;
  description!: string;
  photoName!: string;
  productInStock!: number;
  author!: Author;
  category!: Category;
  constructor() {
  }

}
