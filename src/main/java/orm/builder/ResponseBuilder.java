package orm.builder;

import orm.Response;

public final class ResponseBuilder {
    private String message;

    private ResponseBuilder() {
    }

    public static ResponseBuilder builder() {
        return new ResponseBuilder();
    }

    public ResponseBuilder message(String message) {
        this.message = message;
        return this;
    }

    public Response build() {
        return new Response(message);
    }
}
