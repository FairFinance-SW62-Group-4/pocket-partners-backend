package fairfinance.pocketpartners.backend.users.interfaces.rest;

import fairfinance.pocketpartners.backend.users.domain.model.commands.AddFriendCommand;
import fairfinance.pocketpartners.backend.users.domain.model.commands.DeleteUserFriendsListCommand;
import fairfinance.pocketpartners.backend.users.domain.model.queries.GetUserFriendsListByUserIdQuery;
import fairfinance.pocketpartners.backend.users.domain.services.UserFriendsListCommandService;
import fairfinance.pocketpartners.backend.users.domain.services.UserFriendsListQueryService;
import fairfinance.pocketpartners.backend.users.interfaces.rest.resources.AddFriendResource;
import fairfinance.pocketpartners.backend.users.interfaces.rest.resources.CreateUserFriendsListResource;
import fairfinance.pocketpartners.backend.users.interfaces.rest.resources.UserFriendsListResource;
import fairfinance.pocketpartners.backend.users.interfaces.rest.transform.AddFriendCommandFromResourceAssembler;
import fairfinance.pocketpartners.backend.users.interfaces.rest.transform.CreateUserFriendsListCommandFromResourceAssembler;
import fairfinance.pocketpartners.backend.users.interfaces.rest.transform.UserFriendsListResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/v1/userFriendsList", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "User Friends List", description = "User Friends List Management Endpoints")
public class UserFriendsListController {

    private final UserFriendsListQueryService userFriendsListQueryService;
    private final UserFriendsListCommandService userFriendsListCommandService;

    public UserFriendsListController(UserFriendsListQueryService userFriendsListQueryService, UserFriendsListCommandService userFriendsListCommandService) {
        this.userFriendsListQueryService = userFriendsListQueryService;
        this.userFriendsListCommandService = userFriendsListCommandService;
    }

    // CREATE
    @Operation(summary = "Create a new user friends list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User friends list created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping
    public ResponseEntity<UserFriendsListResource> createUserFriendsList(@RequestBody CreateUserFriendsListResource resource) {
        var createFriendsListCommand = CreateUserFriendsListCommandFromResourceAssembler.toCommandFromResource(resource);
        var friendsList = userFriendsListCommandService.handle(createFriendsListCommand);
        if (friendsList.isEmpty()) return ResponseEntity.badRequest().build();
        var friendsListResource = UserFriendsListResourceFromEntityAssembler.toResourceFromEntity(friendsList.get());
        return new ResponseEntity<>(friendsListResource, HttpStatus.CREATED);
    }

    // GET BY USER ID
    @Operation(summary = "Get user friends list by User ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User friends list found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "User friends list not found")
    })
    @GetMapping("/userId/{userId}")
    public ResponseEntity<UserFriendsListResource> getFriendsListByUserId(@PathVariable Long userId) {
        var getUserFriendsListByUserIdQuery = new GetUserFriendsListByUserIdQuery(userId);
        var friendsList = userFriendsListQueryService.handle(getUserFriendsListByUserIdQuery);
        if (friendsList.isEmpty()) return ResponseEntity.notFound().build();
        var friendsListResource = UserFriendsListResourceFromEntityAssembler.toResourceFromEntity(friendsList.get());
        return ResponseEntity.ok(friendsListResource);
    }

    // ADD FRIEND
    @Operation(summary = "Add a friend to user friends list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Friend added successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "User friends list not found")
    })
    @PostMapping("/addFriend")
    public ResponseEntity<UserFriendsListResource> addFriend(@RequestBody AddFriendResource resource) {
        var addFriendCommand = AddFriendCommandFromResourceAssembler.toCommandFromResource(resource);
        var updatedFriendsList = userFriendsListCommandService.handle(addFriendCommand);
        if (updatedFriendsList.isEmpty()) return ResponseEntity.notFound().build();
        var friendsListResource = UserFriendsListResourceFromEntityAssembler.toResourceFromEntity(updatedFriendsList.get());
        return ResponseEntity.ok(friendsListResource);
    }

    // DELETE FRIENDS LIST
    @Operation(summary = "Delete user friends list by User ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User friends list deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "User friends list not found")
    })
    @DeleteMapping("/userId/{userId}")
    public ResponseEntity<Void> deleteFriendsList(@PathVariable Long userId) {
        var deleteFriendsListCommand = new DeleteUserFriendsListCommand(userId);
        var friendsListDeleted = userFriendsListCommandService.handle(deleteFriendsListCommand);
        if (friendsListDeleted.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}