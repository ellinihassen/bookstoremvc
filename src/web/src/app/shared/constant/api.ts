export const APIS: any = {
  author: {
    GET: {url: 'authors', method: 'GET'},
    ADD: {url: 'authors', method: 'POST'},
    DELETE: {url: 'authors', method: 'DELETE'},
    UPDATE: {url: 'authors', method: 'PUT'}
  },
  addresse: {
    GET: {url: 'addresses', method: 'GET'},
    ADD: {url: 'addresses', method: 'POST'},
    DELETE: {url: 'addresses', method: 'DELETE'},
    UPDATE: {url: 'addresses', method: 'PUT'}
  },
  book: {
    GET: {url: 'books', method: 'GET'},
    ADD: {url: 'books', method: 'POST'},
    DELETE: {url: 'books', method: 'DELETE'},
    UPDATE: {url: 'books', method: 'PUT'},
    CALCULATE_TOTAL_AMOUNT: {url: 'books/calculateTotalAmount', method: 'POST'}
  },
  category: {
    GET: {url: 'categories', method: 'GET'},
    ADD: {url: 'categories', method: 'POST'},
    DELETE: {url: 'categories', method: 'DELETE'},
    UPDATE: {url: 'categories', method: 'PUT'}
  },
  order: {
    GET: {url: 'orders', method: 'GET'},
    ADD: {url: 'orders', method: 'POST'},
    DELETE: {url: 'orders', method: 'DELETE'},
    UPDATE: {url: 'orders', method: 'PUT'}
  },
  item: {
    GET: {url: 'items', method: 'GET'},
    ADD: {url: 'items', method: 'POST'},
    DELETE: {url: 'items', method: 'DELETE'},
    UPDATE: {url: 'items', method: 'PUT'}
  },
  user: {
    GET: {url: 'users', method: 'GET'},
    ADD: {url: 'users', method: 'POST'},
    DELETE: {url: 'users', method: 'DELETE'},
    UPDATE: {url: 'users', method: 'PUT'}
  }


};

export function setIdToURL(id: number, endpoint: any): any {

  const obj = {
    url: endpoint.url + '/' + id,
    method: endpoint.method
  };
  return obj;
}
