package at.avox.bike.tasks.controller.dto;

public record ErrorResponseDto(
    String error,
    String message
) {
}
