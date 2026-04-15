package com.bugtracker.serviceImpl;

import com.bugtracker.entity.Bug;
import com.bugtracker.entity.User;
import com.bugtracker.repository.BugRepository;
import com.bugtracker.repository.UserRepository;
import com.bugtracker.service.BugService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BugServiceImpl implements BugService {

    @Autowired
    private BugRepository bugRepository;

    @Autowired
    private UserRepository userRepository;

    // COUNT METHODS
    
    // Get total number of bugs
    @Override
    public long countTotalBugs() {
        return bugRepository.count();
    }

    // Count bugs with OPEN status
    @Override
    public long countOpenBugs() {
        return bugRepository.countByStatus("OPEN");
    }

    // Count bugs with RESOLVED status
    @Override
    public long countResolvedBugs() {
        return bugRepository.countByStatus("RESOLVED");
    }
    
    // Count bugs with CLOSED status
    @Override
    public long countClosedBugs() {   
        return bugRepository.countByStatus("CLOSED");
    }

    // Count bugs with CRITICAL priority
    @Override
    public long countCriticalBugs() {
        return bugRepository.countByPriority("CRITICAL");
    }

    // BUG FETCHING METHODS

    // Get all bugs
    @Override
    public List<Bug> getAllBugs() {
        return bugRepository.findAll();
    }

    // Get bugs that are not assigned to any developer
    @Override
    public List<Bug> getUnassignedBugs() {
        return bugRepository.findByAssignedDeveloperIsNull();
    }
    
    // Get bugs assigned to a specific developer
    @Override
    public List<Bug> getBugsByDeveloper(User developer) {
        return bugRepository.findByAssignedDeveloper(developer);
    }

    // Get bugs reported by a specific user
    @Override
    public List<Bug> getBugsByReporter(User user) {
        return bugRepository.findByReporter(user);
    }

    // DEVELOPER STATS
 
    // Get bug statistics per developer (name, total, resolved, pending, closed)
    @Override
    public List<Map<String, Object>> getBugsPerDeveloper() {

        List<Object[]> results = bugRepository.countBugsPerDeveloper();
        List<Map<String, Object>> list = new ArrayList<>();

        for (Object[] row : results) {

            Map<String, Object> map = new HashMap<>();

            map.put("name", row[0]);
            map.put("total", row[1]);
            map.put("resolved", row[2]);
            map.put("pending", row[3]);
            map.put("closed", row[4]);   

            list.add(map);
        }

        return list;
    }

    // STATUS STATISTICS
    
    // Get count of bugs by each status
    @Override
    public Map<String, Long> getBugStatusStats() {

        Map<String, Long> stats = new HashMap<>();

        stats.put("OPEN", bugRepository.countByStatus("OPEN"));
        stats.put("IN_PROGRESS", bugRepository.countByStatus("IN_PROGRESS"));
        stats.put("RESOLVED", bugRepository.countByStatus("RESOLVED"));
        stats.put("CLOSED", bugRepository.countByStatus("CLOSED"));  // ✅ NEW

        return stats;
    }


    // PROJECT STATISTICS
    
    // Get bug count grouped by project
    @Override
    public Map<String, Long> getBugProjectStats() {

        List<Object[]> results = bugRepository.countBugsByProject();
        Map<String, Long> map = new HashMap<>();

        for (Object[] row : results) {
            map.put((String) row[0], (Long) row[1]);
        }

        return map;
    }

    // SAVE / UPDATE
    
    // Save a new bug
    @Override
    public void saveBug(Bug bug) {
        bugRepository.save(bug);
    }

    // Get bug by ID
    @Override
    public Bug getBugById(Long id) {
        return bugRepository.findById(id).orElse(null);
    }

    // Update status of a bug
    @Override
    public void updateBugStatus(Long id, String status) {

        Bug bug = bugRepository.findById(id).orElseThrow();

        bug.setStatus(status);

        bugRepository.save(bug);
    }


    // ASSIGN BUG TO DEVELOPER
    
    // Assign bug to developer and set status to OPEN
    @Override
    public void assignBugToDeveloper(Long bugId, Long developerId) {

        Bug bug = bugRepository.findById(bugId).orElseThrow();
        User developer = userRepository.findById(developerId).orElseThrow();

        bug.setAssignedDeveloper(developer);
        bug.setStatus("OPEN");

        bugRepository.save(bug);
    }

    // REPORTER-BASED COUNT METHODS

    // Count bugs reported by a user
    @Override
    public long countBugsByReporter(User user) {
        return bugRepository.countByReporter(user);
    }

    // Count bugs by reporter and status
    @Override
    public long countBugsByReporterAndStatus(User user, String status) {
        return bugRepository.countByReporterAndStatus(user, status);
    }
}