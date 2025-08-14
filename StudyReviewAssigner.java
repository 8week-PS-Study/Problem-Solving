import java.util.*;

public class StudyReviewAssigner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> members = getListInput(scanner, "스터디원을 입력하세요 (띄어쓰기로 구분): ");
        List<String> problems = getListInput(scanner, "문제들을 입력하세요 (띄어쓰기로 구분): ");

        printSummary(members, problems);

        Set<String> forceInclude = new HashSet<>(getListInput(scanner, "이번 주 우선 선정 대상 입력 (띄어쓰기로 구분, 없으면 Enter): "));
        Set<String> forceExclude = new HashSet<>(getListInput(scanner, "이번 주 제외 대상 입력 (띄어쓰기로 구분, 없으면 Enter): "));

        waitForStart(scanner);

        List<String> validMembers = filterExcludedMembers(members, forceExclude);

        Set<String> selectedMembers = selectMembers(validMembers, forceInclude, 3);
        List<String> selectedProblems = selectRandomItems(problems, 3);

        printResult(forceInclude, forceExclude, selectedMembers, selectedProblems);
        scanner.close();
    }

    // 사용자로부터 리스트 입력받기
    private static List<String> getListInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(input.split(" ")));
    }

    // 입력 요약 출력
    private static void printSummary(List<String> members, List<String> problems) {
        System.out.println("\n✅ 입력 요약:");
        System.out.println("- 스터디원 수: " + members.size());
        System.out.println("- 스터디원 목록: " + members);
        System.out.println("- 문제 수: " + problems.size());
        System.out.println("- 문제 목록: " + problems);
        System.out.println();
    }

    // 시작 명령 대기
    private static void waitForStart(Scanner scanner) {
        System.out.print("💬 '시작'을 입력하면 매칭을 시작합니다: ");
        while (!scanner.nextLine().trim().equalsIgnoreCase("시작")) {
            System.out.print("❗ '시작'을 입력해야 매칭이 시작됩니다: ");
        }
    }

    // 제외 대상 필터링
    private static List<String> filterExcludedMembers(List<String> members, Set<String> forceExclude) {
        List<String> filtered = new ArrayList<>();
        for (String member : members) {
            if (!forceExclude.contains(member)) {
                filtered.add(member);
            }
        }
        return filtered;
    }

    // 멤버 선정 (우선 대상 포함 + 랜덤)
    private static Set<String> selectMembers(List<String> candidates, Set<String> forceInclude, int count) {
        List<String> shuffled = new ArrayList<>(candidates);
        Collections.shuffle(shuffled);

        Set<String> selected = new LinkedHashSet<>();

        // 우선 선정 대상 먼저 추가
        for (String include : forceInclude) {
            if (shuffled.contains(include)) {
                selected.add(include);
            }
        }

        // 나머지 무작위로 추가
        for (String member : shuffled) {
            if (selected.size() >= count) break;
            selected.add(member);
        }

        return selected;
    }

    // 문제 무작위 선정
    private static List<String> selectRandomItems(List<String> items, int count) {
        List<String> shuffled = new ArrayList<>(items);
        Collections.shuffle(shuffled);
        return shuffled.subList(0, Math.min(count, shuffled.size()));
    }

    // 최종 결과 출력
    private static void printResult(Set<String> forceInclude, Set<String> forceExclude,
                                    Set<String> selectedMembers, List<String> selectedProblems) {
        System.out.println("\n📌 이번 주 우선 선정 대상: " + forceInclude);
        System.out.println("🚫 이번 주 제외 대상: " + forceExclude);
        System.out.println();

        System.out.println("📝 스터디 문제 리뷰 매칭 결과:");
        Iterator<String> memberIt = selectedMembers.iterator();
        Iterator<String> problemIt = selectedProblems.iterator();

        while (memberIt.hasNext() && problemIt.hasNext()) {
            System.out.println("- " + memberIt.next() + " → " + problemIt.next());
        }
    }
}
